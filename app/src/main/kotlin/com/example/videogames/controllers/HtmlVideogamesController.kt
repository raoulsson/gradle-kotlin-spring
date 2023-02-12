package com.example.videogames.controllers

import com.example.videogames.config.ConfigProperties
import com.example.videogames.dto.CreateGameFormData
import com.example.videogames.service.GameService
import jakarta.validation.Valid
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus.*
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam


@Controller
class HtmlVideogamesController(
    private val gameService: GameService,
    private val properties: ConfigProperties) {

    val logger: Logger = LoggerFactory.getLogger(this::class.java)

    @GetMapping("/")
    fun index(model: Model): String {
        model["pageSubHeader"] = "Index"
        model["randomPicNum"] = (1..32).random()
        return "index"
    }

    @GetMapping("/games_by_jpa")
    fun gamesByJpa(model: Model): String {
        val games = gameService.findAllGames()
        model["games"] = games
        model["pageSubHeader"] = "Games by JPA"
        model["randomPicNum"] = (1..32).random()
        return "games_by_jpa"
    }

    @GetMapping("/games_by_jooq")
    fun gamesByJooq(@RequestParam(required = false) limit: Int?, model: Model): String {
        val gameAndGenre = gameService.getGamesOrderByGenreName(limit)
        if (gameAndGenre != null) {
            model["games"] = gameAndGenre
        }
        model["pageSubHeader"] = "Games by JOOQ"
        model["randomPicNum"] = (1..32).random()
        return "games_by_jooq"
    }

    @GetMapping("/top_sellers_by_platform")
    fun topSellersByPlatform(@RequestParam(required = false) limit: Int?, model: Model): String {
        val topSellersByPlatform = gameService.getTopSellersByPlatformWeb(limit)
        if (topSellersByPlatform != null) {
            model["top_sellers_by_platform"] = topSellersByPlatform
        }
        model["pageSubHeader"] = "Top Sellers by Platform (DTO)"
        model["randomPicNum"] = (1..32).random()
        return "top_sellers_by_platform"
    }

    @GetMapping("/new_entry_form")
    fun createNew(@RequestParam(required = false) limit: Int?, model: Model): String {
        model["pageSubHeader"] = "Create New Entry"
        model["formData"] = gameService.prepareCreateGameFormData()
        model["randomPicNum"] = (1..32).random()
        return "new_entry_form"
    }

    /**
     * To repeat: when the user submits the form, a HTTP POST is done to the application. This method will handle
     * this request.
     *
     * The method is annotated with @PostMapping to indicate that it should be called when a POST is done.
     * The first parameter of the method is our CreateUserFormData object. By using @ModelAttribute("formData"),
     * we ask Spring to inject the instance here. It will contain the values of the input fields of our Thymeleaf
     * template.
     * The CreateUserFormData is also annotated with @Valid to indicate that the validation annotations on the
     * object need to be checked. If there are any validation errors, they will be added to the BindingResult
     * instance following this parameter.
     * Using the if(bindingResult.hasErrors), we check if there are validation errors. If there are errors, we
     * return the users/create String, which tells Spring to show the create.html template again.
     * If there are no errors, we convert from the CreateUserFormData to the UserCreationParameters object and
     * ask the service to create the user.
     * Finally, we tell the browser to redirect to the /users endpoint by returning the String redirect:/users.
     */
    @PostMapping("/create_new_entry")
    fun createNewEntry(
        @Valid @ModelAttribute("formData") formData: CreateGameFormData,
        bindingResult: BindingResult,
        model: Model
    ): String {
        model["randomPicNum"] = (1..32).random()
        logger.info("formData: $formData")

        if (bindingResult.hasErrors()) {
            model["pageSubHeader"] = "Create New Entry - Validation Errors"
            return "create_new_entry";
        }

        gameService.createGame(formData.toParameters())

        model["pageSubHeader"] = "Saved New Entry"

		// use this if returning to same page to prevent a resubmission, by sending a 3xx client-side redirect
        //return "redirect:/same_page"
        return "/index"
    }

}

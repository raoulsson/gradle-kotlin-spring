package com.example.videogames.dto

import com.example.videogames.dao.GameCreationParameters
import com.example.videogames.persistence.GenreEntity
import org.jetbrains.annotations.NotNull

/**
 * https://www.wimdeblauwe.com/blog/2021/05/23/form-handling-with-thymeleaf/
 *
 * The CreateUserFormData also resides in the user.web package as it is something that is only needed for our HTML port.
 * There are validation annotations present to ensure givenName and familyName contain valid fields.
 * The class is mutable. It does not throw any exception to avoid that a field contains an invalid value. This is needed because we will set up a two-way binding from the HTML input fields to the fields of this class. We want to be able to store "invalid" values in our form data objects so that we when show the HTML form again to the user, his invalid input is still there. This would be impossible if we use the UserCreationParameters object directly (as that class probably will throw an IllegalArgumentException when invalid data is passed in).
 * There is a method to convert from this object to the immutable UserCreationParameters object.
 */
data class CreateGameFormData(
    @NotNull var newGameName: String? = null,
    @NotNull var selectedGenreId: Long? = null,
    var selectedGenreName: String? = null
) {

    /**
     * This one carries data to the front, but we don't need it on return
     */
    var allGenresDropDownData: List<GenreEntity>? = null

    /**
     * It was good to have the NotNull annotation for validation, but on a JVM level, we made it nullable, so we can
     * run through the validation. Now we are ready and are assured the values are present so we can send them to
     * the backend for storage in the db
     */
    fun toParameters(): GameCreationParameters {
        return GameCreationParameters(newGameName!!, selectedGenreId!!)
    }

}
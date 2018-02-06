package id.co.imastudio.cobadagger4.model

import com.google.gson.annotations.SerializedName

data class ContactsItem(

		@field:SerializedName("address")
	val address: String? = null,

		@field:SerializedName("gender")
	val gender: String? = null,

		@field:SerializedName("phone")
	val phone: Phone? = null,

		@field:SerializedName("name")
	val name: String? = null,

		@field:SerializedName("id")
	val id: String? = null,

		@field:SerializedName("email")
	val email: String? = null
)
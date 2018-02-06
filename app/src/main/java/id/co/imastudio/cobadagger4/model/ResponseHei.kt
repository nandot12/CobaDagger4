package id.co.imastudio.cobadagger4.model

import com.google.gson.annotations.SerializedName
import id.co.imastudio.cobadagger4.model.ContactsItem

data class ResponseHei(

	@field:SerializedName("contacts")
	val contacts: List<ContactsItem?>? = null
)
package id.co.imastudio.cobadagger4.service

import id.co.imastudio.cobadagger4.model.ResponseHei
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by nandoseptianhusni on 2/7/18.
 */
interface ServiceApi {

    @GET("contacts")
    fun getDetail() : Call<ResponseHei>
}
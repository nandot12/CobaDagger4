package id.co.imastudio.cobadagger4

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import id.co.imastudio.cobadagger4.model.ResponseHei
import id.co.imastudio.cobadagger4.service.ServiceApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

@Inject lateinit var serviceApi: ServiceApi



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as MovieApp).provideApplicationComponent().inject(this)


        serviceApi.getDetail().enqueue(object :Callback<ResponseHei>{
            override fun onFailure(call: Call<ResponseHei>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<ResponseHei>?, response: Response<ResponseHei>?) {


            }
        })


    }
}

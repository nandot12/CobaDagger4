package id.co.imastudio.cobadagger4.di

import android.content.Context
import dagger.Module
import dagger.Provides
import id.co.imastudio.cobadagger4.service.ServiceApi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by nandoseptianhusni on 2/7/18.
 */
@Module
class NetworkModule(val context : Context) {

    fun getInterceptor(): Interceptor {
        return Interceptor { chain ->
            val request = chain.request()
            val builder = request.newBuilder()

            builder.addHeader("Content-Type", "application/json")
            chain.proceed(request)
        }
    }

    @Provides
    @Singleton
    fun getOkHttpClient(): ServiceApi {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        var okhhtp =  OkHttpClient.Builder()

                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .addInterceptor(getInterceptor())
                .addInterceptor(httpLoggingInterceptor)

                .build()

        //   @Configs val baseUrl = Config.BASE_URL
        val retrofit = Retrofit.Builder()
                .client(okhhtp)
                .baseUrl("https://api.androidhive.info/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        return retrofit.create(ServiceApi::class.java)
    }
}
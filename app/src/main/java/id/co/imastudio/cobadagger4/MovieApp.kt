package id.co.imastudio.cobadagger4

import android.app.Application
import id.co.imastudio.cobadagger4.di.ApplicationComponent
import id.co.imastudio.cobadagger4.di.DaggerApplicationComponent
import id.co.imastudio.cobadagger4.di.NetworkModule

/**
 * Created by nandoseptianhusni on 2/7/18.
 */
class MovieApp : Application() {

    lateinit var component : ApplicationComponent
    override fun onCreate() {
        super.onCreate()

        component = DaggerApplicationComponent.builder()
                .networkModule(NetworkModule(this))
                .build()
    }


    fun provideApplicationComponent() : ApplicationComponent = component


}
package id.co.imastudio.cobadagger4.di

import dagger.Component
import id.co.imastudio.cobadagger4.MainActivity
import javax.inject.Singleton

/**
 * Created by nandoseptianhusni on 2/7/18.
 */

@Singleton
@Component(modules = arrayOf(NetworkModule::class))
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity)

}
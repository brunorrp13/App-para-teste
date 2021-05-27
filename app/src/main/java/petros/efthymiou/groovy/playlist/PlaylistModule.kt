package petros.efthymiou.groovy.playlist

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PlaylistModule {

    @Provides
    @Singleton
    fun playlistAPI(retrofit: Retrofit) = retrofit.create(PlaylistAPI::class.java)


    @Provides
    @Singleton
    fun retrofit() = Retrofit.Builder()
        .baseUrl("http://192.168.0.26:2900/")
        .client(OkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}
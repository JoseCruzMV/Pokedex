package com.example.pokedex

import android.app.Application
import com.example.pokedex.data.PokemonRepository
import com.example.pokedex.data.network.PokemonApiClient
import com.example.pokedex.data.network.PokemonService
import com.example.pokedex.domain.GetPokemonListUseCase
import com.example.pokedex.ui.viewmodel.PokemonListViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val url = "https://pokeapi.co/api/v2/"

class PokedexApp : Application() {
    private val koinModule = module {
        single { provideRetrofit() }
        single { providePokemonApi(get()) }
        single { PokemonService(get()) }
        single { PokemonRepository(get()) }
        single { GetPokemonListUseCase(get()) }
        viewModel { PokemonListViewModel(get()) }
    }

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@PokedexApp)
            modules(koinModule)
        }
    }

    private fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private fun providePokemonApi(retrofit: Retrofit): PokemonApiClient =
        retrofit.create(PokemonApiClient::class.java)
}
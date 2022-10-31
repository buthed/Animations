package com.tematihonov.animation.presentation.di

import android.content.Context
import com.tematihonov.animation.presentation.flipCard.CardFlipFragment
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AnimationHiltModule {

//    @Provides
//    @Singleton
//    @ApplicationContext
//    fun provideContext(@ApplicationContext context: Context): CardFlipFragment {
//        return CardFlipFragment(context)
//    }
}
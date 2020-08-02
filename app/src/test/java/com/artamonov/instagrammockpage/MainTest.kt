package com.artamonov.instagrammockpage

import junit.framework.Assert.*
import org.junit.Before
import org.junit.Test

class MainTest {

    private lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        viewModel = MainViewModel()
    }

    @Test
    fun `getPosts() returns 2 posts`() {
        assertEquals(2, viewModel.getPosts().size)
    }

    @Test
    fun `first post author is milena_thebrowbar`() {
        assertEquals("milena_thebrowbar", viewModel.getPosts()[0].author)
    }

}
package com.dreyer.coffeemasters

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.dreyer.coffeemasters.ui.theme.CoffeeMastersTheme



@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun App() {
    Scaffold(
        topBar = {
                 TopAppBar() {
                     AppTitle()
                 }
        },
        bottomBar = {}
    ){
        OffersPage()
    }

}


@Preview
@Composable
fun AppTitle() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(painter = painterResource(id = R.drawable.logo),
            contentDescription = "Coffee Masters Logo")
    }
}
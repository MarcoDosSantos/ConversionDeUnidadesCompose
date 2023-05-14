package com.example.conversiondeunidadescompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.conversiondeunidadescompose.compose.BaseScreen
import com.example.conversiondeunidadescompose.data.ConverterDao
import com.example.conversiondeunidadescompose.data.ConverterDatabase
import com.example.conversiondeunidadescompose.data.ConverterRepositoryImp
import com.example.conversiondeunidadescompose.ui.theme.ConversionDeUnidadesComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dao = ConverterDatabase.getInstance(application).converterDao
        val repository = ConverterRepositoryImp(dao)
        val factory = ConverterViewModelFactory(repository = repository)
        setContent {
            ConversionDeUnidadesComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BaseScreen(factory = factory)
                }
            }
        }
    }
}

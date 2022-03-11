package com.example.jetpackcomposeregandlogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposeregandlogin.pages.LoginPage
import com.example.jetpackcomposeregandlogin.pages.RegisterPage
import com.example.jetpackcomposeregandlogin.ui.theme.JetPackComposeRegAndLoginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeRegAndLoginTheme {

                // this part handles navigation

                val navController = rememberNavController()
                NavHost(navController = navController, startDestination ="/login-page"){
                    composable(
                        route ="/login-page"
                    ){
                        //parsing navController so we can navigate in login page
                        LoginPage(navController)
                    }
                    composable(
                        route ="/register-page"
                    ){
                        //parsing navController so we can navigate in register page
                        RegisterPage(navController)
                    }
                }
            }
        }
    }
}
// lets build component that we will use in the pages
@Composable
fun PrimaryTextField(
    value:String,
    onValueChange: (String)-> Unit,
    modifier: Modifier=Modifier,
    label:@Composable (() ->Unit)? =null,
    leadingIcon:@Composable (() ->Unit)? =null,
    trailingIcon:@Composable (() ->Unit)? =null,
    isError: Boolean=false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions =KeyboardOptions.Default,
    keyboardActions: KeyboardActions?= null,
    singleLine: Boolean=false,
    maxLine: Int =Int.MAX_VALUE,
){
    val focusManager = LocalFocusManager.current
    OutlinedTextField(
        value = value,
        modifier =modifier,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            backgroundColor = Color.Transparent,
            unfocusedBorderColor = Color.LightGray,
            focusedBorderColor = Color.Black,
            leadingIconColor = Color.LightGray,
        ),
        keyboardOptions =keyboardOptions,
        keyboardActions =keyboardActions ?: KeyboardActions(
            onDone = {
                focusManager.clearFocus()
            },
        ),
        isError=isError,
        singleLine =singleLine,
        maxLines = maxLine,
        label =label,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        visualTransformation =visualTransformation,
        onValueChange = onValueChange,
    )
}
@Composable
fun SocialLogin(
    modifier: Modifier =Modifier
){
    Column(modifier =modifier) {
        OutlinedButton(onClick = {},
            modifier = modifier.fillMaxWidth(),
            contentPadding = PaddingValues(vertical = 15.dp),
            shape = RoundedCornerShape(15.dp)
        ) {
            Image(painter = painterResource(id = R.drawable.google),
                contentDescription = "Google logo",
                modifier = Modifier.size(24.dp)
            )
            Text(
                "Login with Google",
                color = Color.LightGray,
                modifier =Modifier.padding(10.dp)
            )

        }
        OutlinedButton(onClick = { },
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 15.dp),
            contentPadding = PaddingValues(vertical = 15.dp),
            shape = RoundedCornerShape(15.dp)
        ) {
            Image(painter = painterResource(id = R.drawable.facebook),
                contentDescription = "Facebook logo",
                modifier = Modifier.size(24.dp)
            )
            Text(
                "Login with Facebook",
                color = Color.LightGray,
                modifier =Modifier.padding(10.dp)
            )

        }
    }
}


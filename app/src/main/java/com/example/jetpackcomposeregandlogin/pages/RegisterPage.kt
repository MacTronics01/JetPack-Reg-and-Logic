package com.example.jetpackcomposeregandlogin.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jetpackcomposeregandlogin.PrimaryTextField
import com.example.jetpackcomposeregandlogin.R
import com.example.jetpackcomposeregandlogin.SocialLogin

@Composable
fun RegisterPage(navController: NavController){
    var username by remember{ mutableStateOf("") }
    var email by remember{ mutableStateOf("") }
    var password by remember{ mutableStateOf("") }
    var visibilityPassword by remember{ mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar (
                backgroundColor = Color.DarkGray,
                elevation = 0.dp
                    ){
                IconButton(onClick = {navController.popBackStack()}) {
                    Icon(Icons.Default.ArrowBack,
                    contentDescription = "Back Button",
                    tint =Color.Black,
                    )

                }
            }
        }

    ) {
        Box(
            modifier = Modifier.fillMaxSize()
                .background(color = Color.DarkGray),
        contentAlignment = Alignment.Center
        ){
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
                .verticalScroll(
                    rememberScrollState()
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Image(painter = painterResource(id =R.drawable.logo),
                contentDescription = "Login Image",
                modifier = Modifier
                    .fillMaxSize()
                    .height(150.dp)
                    .padding(vertical = 20.dp),
            )
            Text( "MACTRONICS",color=Color.Black, style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.CenterHorizontally ).padding(top = 15.dp, bottom = 15.dp)
            )

            Text( "Register",color=Color.Black, style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Start ).padding(top = 15.dp, bottom = 15.dp)
            )
            SocialLogin(
                modifier = Modifier.padding(top = 15.dp)
            )

            Text(
                "Register with Email",
                color = Color.LightGray,
                style = MaterialTheme.typography.caption,
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally).padding(top = 15.dp)
            )
            PrimaryTextField(
                value = username,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 15.dp),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Text,
                ),
                singleLine = true,
                maxLine = 1,
                label = { Text("Username", color = Color.LightGray) },
                leadingIcon = { Icon(Icons.Outlined.Person, contentDescription = "Username Icon") },
                onValueChange = { username = it }
            )
            PrimaryTextField(
                value = email,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 12.dp),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Email,
                ),
                singleLine = true,
                maxLine = 1,
                label = { Text("Email", color = Color.LightGray) },
                leadingIcon = { Icon(Icons.Outlined.Email, contentDescription = "Email Icon") },
                onValueChange = { email = it }
            )
            PrimaryTextField(
                value = password,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 12.dp),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Password,
                ),
                singleLine = true,
                maxLine = 1,
                label = { Text("Password", color = Color.LightGray) },
                leadingIcon = { Icon(Icons.Outlined.Lock, contentDescription = "Password Icon") },
                trailingIcon = {
                               IconButton(onClick = {
                                   visibilityPassword = !visibilityPassword
                               }) {
                                   val icon=
                                   if (visibilityPassword)Icons.Outlined.Visibility else Icons.Outlined.VisibilityOff
                                   Icon(icon, contentDescription = "Visibility Password" )
                               }
                },
                visualTransformation = if (visibilityPassword) VisualTransformation.None else PasswordVisualTransformation(),
                onValueChange = { password = it }
            )
            Button(onClick = {
                navController.navigate("/login-page")
            },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 45.dp, bottom = 25.dp)
                    .clip(RoundedCornerShape(15.dp)),
                contentPadding = PaddingValues(vertical = 15.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.primary,
                )
            ) {
                Text("Continue",
                    color = Color.White,
                )
          }
    }
}
}
}
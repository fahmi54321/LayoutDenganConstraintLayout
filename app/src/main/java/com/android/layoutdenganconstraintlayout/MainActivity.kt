package com.android.layoutdenganconstraintlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.android.layoutdenganconstraintlayout.ui.theme.LayoutDenganConstraintLayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}


@Composable
fun ConstraintItemScreen() {
    ConstraintLayout {
        val (box, input, button) = createRefs()
        Box(
            modifier = Modifier
                .background(Color.Magenta)
                .fillMaxWidth()
                .height(300.dp)
                .constrainAs(box) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                },
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .size(200.dp)
                    .background(Color.Blue)
            ) {

            }

            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Red)
            ) {

            }

            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Green)
                    .align(Alignment.TopStart)
            )

            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Green)
                    .align(Alignment.TopEnd)
            )

            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Green)
                    .align(Alignment.BottomStart)
            )

            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Green)
                    .align(Alignment.BottomEnd)
            )
        }
        TextField(
            value = "0",
            onValueChange = {},
            modifier = Modifier
                .padding(6.dp)
                .constrainAs(input) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(box.bottom)
                }
        )

        Row(modifier = Modifier.constrainAs(button) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(input.bottom)
        }) {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .weight(1f)
                    .padding(6.dp)
            ) {
                Text(text = "Up")
            }

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .weight(1f)
                    .padding(6.dp)
            ) {
                Text(text = "Down")
            }
        }
    }
}

@Preview
@Composable
fun PreviewConstraintItemScreen() {
    ConstraintItemScreen()
}
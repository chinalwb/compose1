package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp

@Composable
fun PuppyList(modifier: Modifier = Modifier) {
    val puppies = remember { PuppyRepo.getPuppies() }

    val scrollState = rememberLazyListState()
    LazyColumn(
        state = scrollState, modifier = modifier.padding(
            horizontal = 16.dp,
            vertical = 0.dp
        )
    ) {
        items(puppies) { puppy ->
            PuppyItem(puppy)
            Divider(startIndent = 0.dp)
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PuppyItem(
    puppy: Puppy,
    modifier: Modifier = Modifier
) {
    ListItem(modifier = modifier
        .clickable { /* todo */ }
        .padding(vertical = 8.dp),
        icon = {
            Image(
                painter = painterResource(puppy.imageId),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .clip(
                        shape = MaterialTheme.shapes.small.copy(
                            CornerSize(30.dp)
                        )
                    ),
                contentScale = ContentScale.Crop
            )
        },
        text = {
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = puppy.name)
                Text(text = puppy.age)
            }
        },
        secondaryText = {
            PuppyMetadata(puppy)
        }
    )
}


@Composable
private fun PuppyMetadata(
    puppy: Puppy,
    modifier: Modifier = Modifier
) {
    val divider = "  •  "
    val tagDivider = "  "
    val text = buildAnnotatedString {
        append(puppy.gender)
        append(divider)
        val tagStyle = MaterialTheme.typography.overline.toSpanStyle().copy(
            background = MaterialTheme.colors.primary.copy(alpha = 0.1f)
        )
        puppy.tags.forEachIndexed { index, tag ->
            if (index != 0) {
                append(tagDivider)
            }
            withStyle(tagStyle) {
                append(" ${tag.toUpperCase()} ")
            }
        }
    }
    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
        Text(
            text = text,
            style = MaterialTheme.typography.body2,
            modifier = modifier
        )
    }
}
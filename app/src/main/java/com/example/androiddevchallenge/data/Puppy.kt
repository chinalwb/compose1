package com.example.androiddevchallenge

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable

@Immutable
data class Puppy(
    val name: String,
    val age: String,
    val gender: String,
    val desc: String,
    @DrawableRes val imageId: Int,
    val tags: Set<String>
)

object PuppyRepo {
    fun getPuppies(): List<Puppy> = puppies
}

private val p1 = Puppy(
    name = "Bella",
    age = "1 year",
    gender = "male",
    desc = "He has beautiful, jade-green eyes.",
    imageId = R.drawable.p1,
    tags = setOf("Beautiful", "Cute")
)

private val p2 = Puppy(
    name = "Charlie",
    age = "1 year",
    gender = "male",
    desc = "His fur is silky and smooth.",
    imageId = R.drawable.p2,
    tags = setOf("Beautiful", "Cute")
)

private val p3 = Puppy(
    name = "Luna",
    age = "6 months",
    gender = "female",
    desc = "She has tiny, hedgehog paws.",
    imageId = R.drawable.p3,
    tags = setOf("Beautiful", "Cute")
)


private val p4 = Puppy(
    name = "Lucy",
    age = "1 year",
    gender = "male",
    desc = "Wagging his tail is his favourite activity!",
    imageId = R.drawable.p4,
    tags = setOf("Beautiful", "Cute")
)


private val p5 = Puppy(
    name = "Max",
    age = "2 years",
    gender = "male",
    desc = "He is very playful and a joy to be around.",
    imageId = R.drawable.p5,
    tags = setOf("Beautiful", "Cute")
)

private val p6 = Puppy(
    name = "Bailey",
    age = "9 months",
    gender = "male",
    desc = "His teeth are as sharp as needles.",
    imageId = R.drawable.p6,
    tags = setOf("Beautiful", "Cute")
)


private val p7 = Puppy(
    name = "Cooper",
    age = "1 year",
    gender = "male",
    desc = "He is always yelping at the cat.",
    imageId = R.drawable.p7,
    tags = setOf("Beautiful", "Cute")
)


private val p8 = Puppy(
    name = "Daisy",
    age = "1 year",
    gender = "male",
    desc = "I love him because he is so cuddly.",
    imageId = R.drawable.p8,
    tags = setOf("Beautiful", "Cute")
)


private val p9 = Puppy(
    name = "Lucy",
    age = "1 year",
    gender = "female",
    desc = "Sometimes she can be very wobbly on her feet.",
    imageId = R.drawable.p9,
    tags = setOf("Beautiful", "Cute")
)

private val puppies = listOf(
    p1,
    p2,
    p3,
    p4,
    p5,
    p6,
    p7,
    p8,
    p9
)
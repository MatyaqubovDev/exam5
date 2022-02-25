package dev.matyaqubov.modul05exam.model

class Feed {

    var restaurant: Restaurant? = null

    var category = ArrayList<Category>()

    constructor(restaurant: Restaurant) {
        this.restaurant = restaurant
    }

    constructor(stories: ArrayList<Category>) {
        this.category = stories
    }
}
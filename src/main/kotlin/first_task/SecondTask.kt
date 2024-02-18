package org.example.first_task

fun main() {

    val exhibition = Exhibition()

    exhibition.Picture(artistName = "Diego Velázquez", pictureName = "Las Meninas")
    exhibition.Picture(artistName = "The Peaceable Kingdom ", pictureName = "Edward Hicks")

    println(exhibition.getState())
    exhibition.listOfPictures.forEach {
        it.changePictureState(true)
        println(exhibition.getState())
    }
}

class Exhibition(
    private var state: Boolean = false,
    val listOfPictures: MutableList<Picture> = mutableListOf()
) {

    private fun changeState(newState: Boolean) {
        state = newState
    }

    fun getState() = state


    inner class Picture(
        private val artistName: String,
        private val pictureName: String,
        private var ready: Boolean = false
    ) {
        init {
            listOfPictures.add(this)
        }

        override fun toString(): String = "$artistName $pictureName"

        fun changePictureState(newState: Boolean) {
            ready = newState
            checkExhibitionState()
        }

        private fun checkExhibitionState() {
            changeState(listOfPictures.find { !it.ready } == null)
        }

    }
}
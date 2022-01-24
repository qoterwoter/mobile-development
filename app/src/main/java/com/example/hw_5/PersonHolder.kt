package com.example.hw_5

import android.util.Log

typealias PersonListener = (person: Person?) -> Unit

object PersonHolder {

    val personsList = mutableListOf<Person>()
    private val myListener = mutableSetOf<PersonListener>()

    init {
        personsList.add(
            Person(
                R.drawable.buffett,
                "Уоррен Баффетт",
                "1930-сейчас",
                "Уоррен Баффетт является одним из самых богатых людей в мире. Один из крупнейших благотворителей в истории человечества.",
                "МУЖЧИНА"))
        personsList.add(
            Person(
                R.drawable.einstein,
                "Альберт Эйнштейн",
                "1879-1955",
                "Физик-теоретик, один из основателей современной теоретической физики, лауреат Нобелевской премии по физике 1921 года.",
                "МУЖЧИНА"))
        personsList.add(
            Person(
                R.drawable.ford,
                "Генри Форд",
                "1863-1947",
                "Американский промышленник, владелец заводов по производству автомобилей по всему миру, изобретатель, автор 161 патента США.",
                "МУЖЧИНА"))
        personsList.add(
            Person(
                R.drawable.jobs,
                "Стивен Джобс",
                "1955-2011",
                "Американский изобретатель, получивший широкое признание в качестве пионера эры информационных технологий.",
                "МУЖЧИНА"))
        personsList.add(
            Person(
                R.drawable.kennedy,
                "Джон Кеннеди",
                "1917-1963",
                "Американский политический, государственный и общественный деятель, 35-й президент США.",
                "МУЖЧИНА"))
        personsList.add(
            Person(
                R.drawable.marx,
                "Карл Маркс",
                "1818-1883",
                "Немецкий философ, социолог, экономист, писатель, поэт, политический журналист, лингвист, общественный деятель, историк.",
                "МУЖЧИНА"))
        personsList.add(
            Person(
                R.drawable.rockefeller,
                "Джон Рокфеллер",
                "1839-1937",
                "Американский предприниматель, филантроп, первый официальный долларовый миллиардер в истории человечества.",
                "МУЖЧИНА"))
        personsList.add(
            Person(
                R.drawable.shanel,
                "Габриэль Шанель",
                "1883-1971",
                "Французский модельер, основательница модного дома Chanel. Оказала существенное влияние на европейскую моду XX века.",
                "ЖЕНЩИНА"))
        personsList.add(
            Person(
                R.drawable.tesla,
                "Никола Тесла",
                "1856-1943",
                "Изобретатель в области электротехники и радиотехники сербского происхождения, учёный, инженер, физик.",
                "МУЖЧИНА"))
        personsList.add(
            Person(
                R.drawable.washington,
                "Джордж Вашингтон",
                "1732-1799",
                "Американский государственный и политический деятель, первый всенародно избранный президент США (1789—1797).",
                "МУЖЧИНА"))
    }

    fun addListener(listener: PersonListener) {
        myListener.add(listener)
    }

    fun sendMessage() {
        Log.i("my_tag", "Send")
        for (listener in myListener)
            listener.invoke(personsList.firstOrNull())
        if (personsList.count() > 0)
            personsList.removeAt(0)
    }
}
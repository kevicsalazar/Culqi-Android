package com.kevicsalazar.culqi.utils

import android.widget.TextView

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */

fun TextView.textChangedListener(init: TextWatcher.() -> Unit) {

    val listener = TextWatcher()

    listener.init()

    addTextChangedListener(listener)

}

class TextWatcher : android.text.TextWatcher {

    private var _beforeTextChanged: ((CharSequence?, Int, Int, Int) -> Unit)? = null

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        _beforeTextChanged?.invoke(s, start, count, after)
    }

    fun beforeTextChanged(listener: (CharSequence?, Int, Int, Int) -> Unit) {
        _beforeTextChanged = listener
    }

    private var _onTextChanged: ((CharSequence?, Int, Int, Int) -> Unit)? = null

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        _onTextChanged?.invoke(s, start, before, count)
    }

    fun onTextChanged(listener: (CharSequence?, Int, Int, Int) -> Unit) {
        _onTextChanged = listener
    }

    private var _afterTextChanged: ((android.text.Editable?) -> Unit)? = null

    override fun afterTextChanged(s: android.text.Editable?) {
        _afterTextChanged?.invoke(s)
    }

    fun afterTextChanged(listener: (android.text.Editable?) -> Unit) {
        _afterTextChanged = listener
    }

}
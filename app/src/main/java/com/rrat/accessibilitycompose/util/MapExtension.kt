package com.rrat.accessibilitycompose.util



internal fun <E> MutableSet<E>.addOrRemove(element: E){
    if(!add(element)){
        remove(element)
    }
}
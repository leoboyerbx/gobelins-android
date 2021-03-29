val list = mutableListOf<Int>()

repeat(50) {
    list.add(it)
}

println(list)

list.filter {
    it % 2 == 0
}


package racingcar

import camp.nextstep.edu.missionutils.Console

class RacingGame {
    private lateinit var carList: List<Car>

    fun init() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        carList = Console.readLine().split(",").map { Car(it) }
        println("시도할 횟수는 몇 회인가요?")
        val moveCount = Console.readLine().toInt()
        racing(moveCount)
    }

    private fun racing(moveCount: Int) {
        println("실행 결과")
        repeat(moveCount) {
            carList.forEach { it.carMove() }
            println()
        }
        result()
    }

    private fun result() {
        println("최종 우승자 : " + carList.filter {
            it.getPosition() == carList.maxByOrNull { car ->
                car.getPosition()
            }!!.getPosition()
        }.joinToString(", ") { it.name })
    }
}
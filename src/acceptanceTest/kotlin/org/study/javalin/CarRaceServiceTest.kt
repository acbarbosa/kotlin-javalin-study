package org.study.javalin

import org.junit.jupiter.api.Test
import org.study.javalin.services.CarRaceService
import io.mockk.mockk

class CarRaceServiceTest {
    @Test
    fun `check car two is in the first position`() {
        val mockCarRaceService = mockk<CarRaceService>()

        mockCarRaceService.carRace().getFirstPosition()
    }
}
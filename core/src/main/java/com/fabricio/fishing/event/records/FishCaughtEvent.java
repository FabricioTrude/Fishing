package com.fabricio.fishing.event.records;

import com.fabricio.fishing.features.fishing.Fish;

public record FishCaughtEvent(Fish fish, float amount) {}

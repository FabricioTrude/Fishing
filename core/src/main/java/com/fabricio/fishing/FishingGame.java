package com.fabricio.fishing;

import com.badlogic.gdx.Game;
import com.fabricio.fishing.screen.GameScreen;

// TODO peixes spawnam de fora da tela,
//  nadam aleatóriamente ou seguindo o caminho de IA
//  da classe  passando pela tela o player pode apertar nele
//  enquanto nadam ou quando param
//  (ganhando algum bonus se parados),
//  cada peixe tem uma base de "defesa",
//  o player precisando apertar várias vezes
//  peixe fazendo um "combo" pra aí sim ele pescar,
//  o anzol vai e volta bem rapidinho conforme ele
//  melhora a vara de pesca cada peixe precisa de menos toques,
//  5 pra 4, pra 3, pra 2, pra 1, e com o tempo ele libera tipo
//  "caixa de isca" que atrai peixes de certos tiers e captura
//  eles sozinhox com o tempo

public class FishingGame extends Game {
    @Override
    public void create() {
        setScreen(new GameScreen());
    }
}

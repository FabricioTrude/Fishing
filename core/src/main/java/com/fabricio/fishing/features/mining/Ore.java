package com.fabricio.fishing.features.mining;

import com.fabricio.fishing.context.statics.C;
import com.fabricio.fishing.entity.StaticEntity;
import com.fabricio.fishing.entity.components.ClickableComponent;
import com.fabricio.fishing.entity.components.HealthComponent;
import com.fabricio.fishing.entity.enums.EntityIndex;
import com.fabricio.fishing.features.mining.enums.Ores;

public class Ore extends StaticEntity{
    Ores ore;
    HealthComponent health;
    ClickableComponent click;

    //todo
    // progressão na mina é horizontal, precisa de outras coisas do jogo pra continuar
    // cada zona terá sua mina com recursos específicos
    // Swamp Cave terá minérios, gemas, pedras, fungos, peixes cavernosos, itens e relíquias específicos de seu bioma,
    // não necessariamente melhores ou piores que algo, apenas definidos
    // profundidade indica sim dificuldade, talvez de poder ou mineração,
    // mas o jogador sempre pode começar do andar mais profundo se quiser só "continuar a descer",
    // ele precisa ter um motivo pra estar em andares específicos, o que nos leva a Biomas Subterrâneos,
    // cada andar ou set de andares terão biomas, o que impacta a gameplay da mina
    // jogador não vai começar do andar 30 pra se dar melhor no andar 50,
    // jogador vai no andar 30 porque precisa do andar 30
    // escadas entre andares de um mesmo bioma aparecem igual stardew, quebrando pedra
    // escada de checkpoints são bloqueadas por algum fator externo
    // biomas devem alterar ambiente e gameplay

    public Ore(float x, float y, float z, Ores ore) {
        super(x, y, z, ore.texture());
        addCategories(EntityIndex.ENTITY, EntityIndex.CLICKABLE);
        this.ore = ore;
        health = new HealthComponent(2);
        click = new ClickableComponent(this,
            ClickableComponent.createPolygon(width, height),
            () -> health.damage(1));
        addComponent(click, health);
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        if(health.isDead()) C.entities().markForRemoval(this);
    }

}

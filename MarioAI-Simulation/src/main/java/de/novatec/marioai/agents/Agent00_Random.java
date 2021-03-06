/*
 * Copyright (c) 2009-2010, Sergey Karakovskiy and Julian Togelius
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the Mario AI nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

package de.novatec.marioai.agents;

import ch.idsia.benchmark.mario.engine.input.MarioInput;
import ch.idsia.benchmark.mario.engine.input.MarioKey;
import de.novatec.marioai.MarioAiAgent;

import java.util.Random;

/**
 * Agent that randomly pushes buttons (slightly prefer right button).
 *
 * @author Sergey Karakovskiy
 * @author Jakub 'Jimmy' Gemrot, gemrot@gamedev.cuni.cz
 */
public class Agent00_Random extends MarioAiAgent {

    private Random random = new Random();

    @Override
    public MarioInput doAiLogic() {
        for (int i = 0; i < MarioKey.numberOfKeys; ++i) {
            boolean toggleParticularAction = random.nextBoolean();
            if (toggleParticularAction) 
            	if (!(MarioKey.getMarioKey(i).equals(MarioKey.LEFT) ||  MarioKey.getMarioKey(i).equals(MarioKey.DOWN) ))
            		getMarioInput().toggle(MarioKey.getMarioKey(i));
        }
        // Prefer movement to the right.
        if (random.nextBoolean()) {
            getMarioInput().press(MarioKey.RIGHT);
        }

        return getMarioInput();
    }

	@Override
	public String getName() {
		return this.getClass().getName();
	}
}

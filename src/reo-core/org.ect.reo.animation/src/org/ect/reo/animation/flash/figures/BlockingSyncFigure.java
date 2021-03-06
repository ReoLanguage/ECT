/*******************************************************************************
 * <copyright>
 * This file is part of the Extensible Coordination Tools (ECT).
 * Copyright (c) 2013 ECT developers. 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *******************************************************************************/
package org.ect.reo.animation.flash.figures;

import org.eclipse.gmf.runtime.notation.Edge;
import org.ect.reo.animation.Animation;
import org.ect.reo.animation.flash.AnimationConstants;


public class BlockingSyncFigure extends ChannelFigure {

	public BlockingSyncFigure(Edge edge, Animation animation) {
		super(edge, animation);
		channelLineWidth = 2 * AnimationConstants.WIDTH_CHANNEL;
	}
	@Override
	protected void initSymbols() {
		addChannelLine(false);
		addSourceArrow();
		addTargetArrow();
    	addNoFlowArrows();
	}
}

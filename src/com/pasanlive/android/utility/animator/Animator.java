package com.pasanlive.android.utility.animator;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Point;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;

public class Animator {

	private List<View> viewList;
	private List<Animation> animationList = new ArrayList<Animation>(0);
	
	public Animator(Context context, List<View> viewList, int animation) {
		this.viewList = viewList;
		
		for (int i = 0; i < viewList.size(); i++) {
			animationList.add(AnimationUtils.loadAnimation(context, animation));
		}
	}
	
	public void start() {
		animate(0);
	}
	
	private void animateNext(int currentPosition) {
		animate(++currentPosition);
	}
	
	private void animate(final int position) {
		if (getView(position) == null) {
			return;
		}
		
		getView(position).startAnimation(animationList.get(position));
		animationList.get(position).setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				if (position < viewList.size()) {
					animateNext(position);
				}
			}
		});
	}
	
	private View getView(int position) {
		if (viewList != null && position < viewList.size()) {
			return viewList.get(position);
		}
		return null;
	}
}

package com.niblvl50.ninja;

import org.anddev.andengine.opengl.texture.BuildableTexture;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.builder.BlackPawnTextureBuilder;
import org.anddev.andengine.opengl.texture.builder.ITextureBuilder.TextureSourcePackingException;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.texture.region.TextureRegionFactory;
import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;
import org.anddev.andengine.ui.activity.BaseGameActivity;

import android.util.Log;

public class Textures
{
	public static BuildableTexture buildableTexture;
	public static TiledTextureRegion ryu;
	public static TextureRegion backgroundSky;
	public static TextureRegion backgroundCloud;
	public static TextureRegion backgroundBushes;
	public static TextureRegion backgroundGrass;
	
	public static void load(BaseGameActivity activity)
	{
		TextureRegionFactory.setAssetBasePath("textures/");
		
		buildableTexture = new BuildableTexture(1024, 512, TextureOptions.DEFAULT);
		
        ryu = TextureRegionFactory.createTiledFromAsset(buildableTexture, activity, "ryu.png", 4, 3);
        backgroundSky = TextureRegionFactory.createFromAsset(buildableTexture, activity, "backgroundSky.png");
        backgroundCloud = TextureRegionFactory.createFromAsset(buildableTexture, activity, "backgroundCloud.png");
        backgroundBushes = TextureRegionFactory.createFromAsset(buildableTexture, activity, "backgroundBushes.png");
        backgroundGrass = TextureRegionFactory.createFromAsset(buildableTexture, activity, "backgroundGrass.png");
        
        try 
        {
            buildableTexture.build(new BlackPawnTextureBuilder(1));
        }
        catch(final TextureSourcePackingException e)
        {
            Log.d("Textures", e.getMessage());
            activity.finish();
        }
       
        activity.getEngine().getTextureManager().loadTextures(buildableTexture);
	}
}

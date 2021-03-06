package me.coley.recaf.config;

import me.coley.recaf.ui.controls.view.ClassViewport;
import me.coley.recaf.ui.controls.view.FileViewport;
import me.coley.recaf.util.LangUtil;
import me.coley.recaf.util.Resource;
import static me.coley.recaf.util.Resource.internal;

/**
 * Display configuration.
 *
 * @author Matt
 */
public class ConfDisplay extends Config {
	/**
	 * Display mode for classes.
	 */
	@Conf("display.classmode")
	public ClassViewport.ClassMode classEditorMode = ClassViewport.ClassMode.DECOMPILE;
	/**
	 * Display mode for files.
	 */
	@Conf("display.filemode")
	public FileViewport.FileMode fileEditorMode = FileViewport.FileMode.AUTOMATIC;
	/**
	 * UI language.
	 */
	@Conf("display.language")
	public Resource language = internal("translations/" + LangUtil.DEFAULT_LANGUAGE + ".json");
	/**
	 * Stylesheet group to use for application styling.
	 */
	@Conf("display.appstyle")
	public Resource appStyle = internal("style/ui-dark.css");
	/**
	 * Theme for decompiler/text view.
	 */
	@Conf("display.textstyle")
	public Resource textStyle = internal("style/text-dark.css");
	/**
	 * Font size.
	 */
	@Conf("display.fontsize")
	public double fontSize = 12;
	/**
	 * Give suggestions when a class-view has errors.
	 */
	@Conf("display.suggest.classerrors")
	public boolean suggestClassWithErrors = true;

	ConfDisplay() {
		super("display");
	}

	@Override
	public void onLoad() {
		LangUtil.load(language);
	}
}

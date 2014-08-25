/*******************************************************************************
 *******************************************************************************/
package de.tub.tfs.henshin.tggeditor.editparts.graphical;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.swt.graphics.Color;

import de.tub.tfs.henshin.tgg.interpreter.util.RuleUtil;
import de.tub.tfs.henshin.tggeditor.ui.TGGEditorConstants;

public class RuleObjectTextWithMarker extends TextWithMarker {

	public RuleObjectTextWithMarker(Color FG){
		super();
		setFG_COLOR(FG);
		setAttributes();
	}
	
	@Override
	public boolean setKnownMarker(String newText) {
		boolean isBasicMarker = super.setKnownMarker(newText);
		if (!isBasicMarker) {
			if (RuleUtil.Translated.equals(newText)) {
				text.setForegroundColor(FG_COLOR);
				marker.setText(newText);
				marker.setFont(TGGEditorConstants.TEXT_BOLD_FONT);
				marker.setForegroundColor(TGGEditorConstants.FG_TRANSLATION_MARKER_COLOR);
			} else if (RuleUtil.NEW.equals(newText)) {
				// text.setForegroundColor(FG_COLOR);
				text.setForegroundColor(ColorConstants.darkGreen);
				marker.setText(newText);
				marker.setFont(TGGEditorConstants.TEXT_BOLD_FONT);
				marker.setForegroundColor(TGGEditorConstants.FG_CREATION_MARKER_COLOR);
			} else
				return false;

			if(!this.getChildren().contains(marker))
				add(marker);
			return true;
		}
		return true;
	}	
	

}

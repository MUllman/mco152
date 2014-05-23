package ullman.earthquakes;

import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

class MyCellRender extends DefaultListCellRenderer {

	@Override
	public Component getListCellRendererComponent(JList<?> list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		super.getListCellRendererComponent(list, value, index, isSelected,
				cellHasFocus);
		if (Double.valueOf(value.toString().substring(0, 3)) <= 1) {
			Color fg = Color.MAGENTA;
			setBackground(fg);
		} else if (Double.valueOf(value.toString().substring(0, 3)) >= 2
				&& Double.valueOf(value.toString().substring(0, 3)) < 3) {
			Color fg = Color.blue;
			setBackground(fg);
		} else if (Double.valueOf(value.toString().substring(0, 3)) >= 3
				&& Double.valueOf(value.toString().substring(0, 3)) < 4) {
			Color fg = Color.GRAY;
			setBackground(fg);
		} else if (Double.valueOf(value.toString().substring(0, 3)) >= 4
				&& Double.valueOf(value.toString().substring(0, 3)) < 5) {
			Color fg = Color.CYAN;
			setBackground(fg);
		} else if (Double.valueOf(value.toString().substring(0, 3)) >= 5
				&& Double.valueOf(value.toString().substring(0, 3)) < 6) {
			Color fg = Color.green;
			setBackground(fg);
		} else if (Double.valueOf(value.toString().substring(0, 3)) >= 6
				&& Double.valueOf(value.toString().substring(0, 3)) < 7) {
			Color fg = Color.yellow;
			setBackground(fg);
		} else if (Double.valueOf(value.toString().substring(0, 3)) >= 7
				&& Double.valueOf(value.toString().substring(0, 3)) < 8) {
			Color fg = Color.orange;
			setBackground(fg);
		} else if (Double.valueOf(value.toString().substring(0, 3)) >= 8
				&& Double.valueOf(value.toString().substring(0, 3)) < 9) {
			Color fg = Color.pink;
			setBackground(fg);
		} else if (Double.valueOf(value.toString().substring(0, 3)) >= 9
				&& Double.valueOf(value.toString().substring(0, 3)) < 10) {
			Color fg = Color.red;
			setBackground(fg);
		} else if (Double.valueOf(value.toString().substring(0, 3)) == 10) {
			Color fg = Color.gray;// no dark red
			setBackground(fg);
		}
		return this;
	}
}

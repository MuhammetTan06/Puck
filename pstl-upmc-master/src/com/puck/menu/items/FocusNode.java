package com.puck.menu.items;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuItem;

import org.piccolo2d.extras.pswing.PSwingCanvas;

import com.puck.arrows.ArrowNodesHolder;
import com.puck.display.piccolo2d.NewDisplayDG;
import com.puck.menu.Menu;
import com.puck.menu.items.removing.RemoveEdgesOf;
import com.puck.nodes.piccolo2d.Node;
import com.puck.nodes.piccolo2d.PiccoloCustomNode;

public class FocusNode extends JMenuItem {
	private NewDisplayDG frame;
	private PiccoloCustomNode pnode;
	
	public FocusNode(PiccoloCustomNode pnode, JFrame frame) {
		super("Focus node ",new ImageIcon("images/hide.png"));
		this.frame = (NewDisplayDG)frame;
		this.pnode = pnode;
	
		addActionListener();
	}
	public void focusNode(PiccoloCustomNode pnode, PSwingCanvas canvas) {
		ArrayList<PiccoloCustomNode> fromAscendency = pnode.getAscendency();
		if (pnode.getParentNode() != null) {
			
		Collection<PiccoloCustomNode> parentChild= pnode.getParentNode().getChildren();
		for (PiccoloCustomNode child : parentChild) {
			//faire direct child au lieu de hierarchy 
			if (!child.equals(pnode)) {
				RemoveEdgesOf removeEdges = new RemoveEdgesOf(child, this.frame);
				removeEdges.drawOutgoingdges(child,canvas);
				pnode.getParentNode().getHiddenchildren().add(child);
				pnode.getParentNode().removeChild(child);
			}
		}	
		}
		if (fromAscendency.size() > 0) {
			fromAscendency.get(fromAscendency.size()-1).setLayout();
		}
		
		
	
	}

	public void addActionListener() {
		this.addActionListener(new AbstractAction() {

			public void actionPerformed(ActionEvent arg0) {
				focusNode(pnode, frame.getCanvas());
			}
		});
	}
}

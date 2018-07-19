package com.puck.menu.items;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import org.piccolo2d.extras.pswing.PSwingCanvas;

import com.puck.arrows.ArrowNodesHolder;
import com.puck.display.piccolo2d.NewDisplayDG;
import com.puck.menu.Menu;
import com.puck.nodes.piccolo2d.Edge;
import com.puck.nodes.piccolo2d.Node;
import com.puck.nodes.piccolo2d.PiccoloCustomNode;
import com.puck.undoRedo.Changeable;
import com.puck.undoRedo.State;
import com.puck.undoRedo.StateChanger2;
import com.puck.utilities.NodeType;
import com.puck.utilities.piccolo2d.PCustomInputEventHandler;

public class AddNode extends JMenuItem {
	
	private PiccoloCustomNode pnode;
	private NodeType nodeType;
	private Changeable state;
	private Collection<PiccoloCustomNode> children;
	private NewDisplayDG frame;

	
	public AddNode(JFrame f, PiccoloCustomNode pnode, NodeType nodeType, Changeable state) {
		super("Add " + nodeType, new ImageIcon("images/add.png"));
		this.frame = (NewDisplayDG)f;
		
		this.pnode = pnode;
		this.nodeType = nodeType;
		this.state = state;
		this.children = pnode.getChildren();
		addActionListener();
	}

	public void addNode(PiccoloCustomNode pnode, PSwingCanvas canvas,String nodeName) {

		switch (nodeType) {
		case CLASS:
			PiccoloCustomNode cla = new PiccoloCustomNode(nodeName, "1000", "class");
			addNodeToParent(cla, nodeName);
			break;
		case PACKAGE:
			PiccoloCustomNode pack = new PiccoloCustomNode(nodeName, "1011", "package");
			addNodeToParent(pack, nodeName);			
			break;
		default:
			break;
		}
	}

	public void addNodeToParent(PiccoloCustomNode nodeToAdd, String name) {
		PiccoloCustomNode root_atpre = PiccoloCustomNode.newInstance(this.frame.getRoot());
	
		
		
		nodeToAdd.setName(name);
		nodeToAdd.setParentNode(pnode);
		nodeToAdd.getContent().getText().addInputEventListener(
				new PCustomInputEventHandler(frame, nodeToAdd));
		children.add(nodeToAdd);
		pnode.setChilldren(children);
		pnode.showChildren();
		
		// undo redo with state
		Stack<State> editedState = StateChanger2.getInstance().getAddedPnodes();
	//	editedState.push(previousState);
		StateChanger2.getInstance().setAddedPnodes(editedState);
		
		
		this.frame.getAllPNodes().put(nodeToAdd.getidNode(), nodeToAdd);

		this.frame.getRoot().setLayout();
		//root.showChildren();
		this.frame.getANH().refreshAllArrows();
		
	//	State currentState = new State(copy(), ANH, canvas,PiccoloCustomNode.newInstance(root));
		editedState = StateChanger2.getInstance().getAddedPnodes();
	//	editedState.push(currentState);
		StateChanger2.getInstance().setAddedPnodes(editedState);
	
	}

	public void addActionListener() {
		this.addActionListener(new AbstractAction() {

			public void actionPerformed(ActionEvent arg0) {
				  String nodeName = JOptionPane.showInputDialog("Add","");
				  if(nodeName==null||nodeName.equals(""))
			            return;
				  
				  addNode(pnode, frame.getCanvas(),nodeName);
			}
		});
	}
	
	
	public HashMap<String, PiccoloCustomNode>  copy() {
		HashMap<String, PiccoloCustomNode> allPNodes_atPre = new HashMap<>();
		for(Map.Entry<String, PiccoloCustomNode> node : this.frame.getAllPNodes().entrySet()) {
			PiccoloCustomNode copy = PiccoloCustomNode.newInstance(node.getValue());
			Collection<PiccoloCustomNode> hide_atPre = new ArrayList<>(node.getValue().getHiddenchildren());
			copy.setHiddenchildren(hide_atPre);
			Collection<PiccoloCustomNode> children_atPre = new ArrayList<>(node.getValue().getChildren());
			copy.setChilldren(children_atPre);
			copy.setParentNode(node.getValue().getParentNode());
			copy.setParent(node.getValue().getParent());
			allPNodes_atPre.put(copy.getidNode(), copy);
		}
		return allPNodes_atPre;
	}
}

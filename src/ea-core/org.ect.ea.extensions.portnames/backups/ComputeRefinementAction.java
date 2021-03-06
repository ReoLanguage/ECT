package org.ect.ea.extensions.portNames.actions;

import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;

import org.ect.ea.automata.Automaton;
import org.ect.ea.diagram.contributions.actions.ChangeExtensionsAction;
import org.ect.ea.diagram.contributions.commands.ChangeExtensionsCommand;


public class ComputeRefinementAction extends ChangeExtensionsAction {
	
	// Id of this action.
	public static final String ID = "org.ect.ea.extensions.portNames.ComputeRefinementAction";
	
	// Name of this action, as it is displayed in the context menu.
	public static final String NAME = "Compute Refinement";
	
	// Selected EditPart.
	private IGraphicalEditPart editpart;
	
	// Selected automaton.
	private Automaton automaton;
	
	
	/**
	 * Default constructor.
	 * @param selection Current selection.
	 */
	public ComputeRefinementAction(IGraphicalEditPart[] selection) {

		setId(ID);
		setText(NAME);
		setToolTipText(NAME);
		
		boolean enabled = isAutomataSelection(selection) && isSingletonSelection(selection);		
		setEnabled(enabled);
		
		if (enabled) {
			editpart = selection[0];
			View view = (View) editpart.getModel();
			automaton = (Automaton) view.getElement();			
		}
	}


	@Override
	protected ChangeExtensionsCommand getCommand() {
		if (editpart==null || automaton==null) return null;		
		return new ComputeRefinementCommand(automaton, editpart);
	}
	
}
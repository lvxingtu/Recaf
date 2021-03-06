package me.coley.recaf.parse.bytecode.ast;

import me.coley.recaf.parse.bytecode.exception.AssemblerException;
import me.coley.recaf.parse.bytecode.Variables;
import org.objectweb.asm.tree.*;

import java.util.Map;

/**
 * Variable instruction AST.
 *
 * @author Matt
 */
public class IincInsnAST extends InsnAST implements VariableReference {
	private final NameAST variable;
	private final NumberAST incr;

	/**
	 * @param line
	 * 		Line number this node is written on.
	 * @param start
	 * 		Offset from line start this node starts at.
	 * @param opcode
	 * 		Opcode AST.
	 * @param variable
	 * 		Variable name AST.
	 * @param incr
	 * 		Increment value AST.
	 */
	public IincInsnAST(int line, int start, OpcodeAST opcode, NameAST variable, NumberAST incr) {
		super(line, start, opcode);
		this.variable = variable;
		this.incr = incr;
		addChild(variable);
		addChild(incr);
	}

	@Override
	public NameAST getVariableName() {
		return variable;
	}

	/**
	 * @return Increment value AST.
	 */
	public NumberAST getIncrement() {
		return incr;
	}

	@Override
	public String print() {
		return getOpcode().print() + " " + variable.print() + " " + incr.print();
	}

	@Override
	public AbstractInsnNode compile(Map<String, LabelNode> labels, Variables variables) throws AssemblerException {
		return new IincInsnNode(getVariableIndex(variables), getIncrement().getIntValue());
	}
}

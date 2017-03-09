package metrics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ast.ClassObject;
import ast.FieldInstructionObject;
import ast.MethodObject;
import ast.SystemObject;
import ast.MethodInvocationObject;

public class CF {

	int client;
	List <String> classNames = new ArrayList<>();
	public CF(SystemObject system){
		client =0;
		Set<ClassObject> classes = system.getClassObjects();
		for(ClassObject co : classes)
		classNames.add(co.getName());
		
		for(ClassObject co : classes){
			client += getCoupling (co);			
		}
		int size = classes.size();
		float CF = (float)client / (size*size -size);
		System.out.println("CF = "+ CF);
		
	}
	private int getCoupling(ClassObject co) {
		Set <String> coupledClasses = new HashSet<>();
		List<MethodObject> methodList = co.getMethodList();
		getMethodInvocationCoupling(co, methodList, coupledClasses);
		getAttributeAccessCoupling(co, methodList, coupledClasses);

		return coupledClasses.size();
	}
	private void getMethodInvocationCoupling(ClassObject co, List<MethodObject> methodList, Set <String> coupledClasses){
				
				for(MethodObject method : methodList) {
					List<MethodInvocationObject> invocationList = method.getMethodInvocations();
					for(MethodInvocationObject invocation : invocationList) {
						if(!invocation.getOriginClassName().equals(co.getName()) && classNames.contains(invocation.getOriginClassName())){
							coupledClasses.add(invocation.getOriginClassName());
						}
			}
				}
	}

	private void getAttributeAccessCoupling (ClassObject co, List<MethodObject> methodList, Set <String> coupledClasses){
		
		for(MethodObject method : methodList) {
			List<FieldInstructionObject> fieldInstructionList = method.getFieldInstructions();
			for(FieldInstructionObject instruction : fieldInstructionList) {
				if(!instruction.getOwnerClass().equals(co.getName()) &&  classNames.contains(instruction.getOwnerClass())) 
					coupledClasses.add(instruction.getOwnerClass());
			}
		}
	}
}

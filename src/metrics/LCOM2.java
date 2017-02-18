package metrics;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ast.ClassObject;
import ast.FieldInstructionObject;
import ast.MethodObject;
import ast.SystemObject;

public class LCOM2 {
	
	private Map <String, Integer> metricmap;
	public LCOM2(SystemObject system){
		metricmap = new HashMap<String, Integer>();
		for(ClassObject classobject :system.getClassObjects()){
			int cohesion = computeCohesion (classobject);
			metricmap.put(classobject.getName(), cohesion);
		}
		
	}
	private int computeCohesion(ClassObject classobject) {
		List <MethodObject> methods = classobject.getMethodList();
		// no method pair
		if(methods.size() <= 1){
			return -1;
		}
		int p=0, q=0;
		//pair i,j = j,i
		for( int i=0; i<methods.size()-1; i++){
			
		MethodObject m1 = methods.get(i);
		List<FieldInstructionObject> attributesI = m1.getFieldInstructions();
			for(int j=i+1; j<methods.size(); j++){
				MethodObject m2 = methods.get(j);
				List<FieldInstructionObject> attributesJ = m2.getFieldInstructions(); //every operation that access/ modify list
				// we need field access commonly from only this class
				boolean c = commonfields (attributesI, attributesJ, classobject);
				if(c)
					q++;
					else
						p++;
			}
		}
		if (p>q)
			return p-q;
		return 0;
	}
	
	private boolean commonfields(List<FieldInstructionObject> attributesI, List<FieldInstructionObject> attributesJ, ClassObject class1){
		for( FieldInstructionObject f1 : attributesI){
			for( FieldInstructionObject f2 : attributesJ){
				if(f1.equals(f2) && f1.getOwnerClass().equals(class1)){
					return true;
				}
			}
		}
		return false;
	}
}

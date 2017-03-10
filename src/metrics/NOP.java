package metrics;

import java.util.List;
import java.util.Set;

import ast.ClassObject;
import ast.MethodObject;
import ast.SystemObject;

/* NOP metric : The type of method objects are checked and the NOP is computed
 * as the count of number of abstract methods in class*/
 
public class NOP {

	public NOP(SystemObject system) {
		Set<ClassObject> classObjects = system.getClassObjects();
		int polyCount = 0;
		boolean returnVal = false;
		for (ClassObject co : classObjects) {
			//System.out.println(co.getName());

			List<MethodObject> methodList = co.getMethodList();

			if (co.getMethodList() != null) {

				for (MethodObject method : methodList) {
					returnVal = isPoly(method);
					if (returnVal) {
						polyCount++;
					}
				}
			}	
		}
		System.out.println("NOP = "+polyCount);
	}
	
	//  to verify whether method  is abstract or not
	private boolean isPoly(MethodObject method) {
		return method.isAbstract();
	}

}

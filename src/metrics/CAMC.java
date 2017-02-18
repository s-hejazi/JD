package metrics;

import ast.SystemObject;
import ast.TypeObject;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ast.ClassObject;
import ast.ConstructorObject;
import ast.MethodObject;

public class CAMC {
	
	public CAMC(SystemObject system)
	{
		Set<ClassObject> classList;
		classList = system.getClassObjects();
		float camc = 0;
		
		//static?
		for (ClassObject co: classList)
		{
			if(co.getMethodList()!= null && co.getMethodList().size() != 0)
			 camc += calculateCAMC(co);
		}
		camc/=classList.size();
		System.out.println("CAMC = " +camc);
	}

	private float calculateCAMC(ClassObject classObject) {
		
		List <MethodObject> methodList = classObject.getMethodList();		
		Set <TypeObject> classParameterTypes = new HashSet <TypeObject>();
		int methodParameterTypeCount = 0;
		
		if(classObject.getConstructorList()!=null)
		{
			for (ConstructorObject o : classObject.getConstructorList()){
				Set <TypeObject> methodParameterTypes = new HashSet <TypeObject>();
				if(o.getParameterList()!= null){
					classParameterTypes.addAll(o.getParameterTypeList());
					methodParameterTypes.addAll(o.getParameterTypeList());
					methodParameterTypeCount += methodParameterTypes.size();
				}
			}
			
		}
	
		for (MethodObject method: methodList)
		{
			//distinct types
			Set <TypeObject> methodParameterTypes = new HashSet <TypeObject>();
			if(method.getParameterList()!=null)
			{
			classParameterTypes.addAll(method.getParameterTypeList());
			methodParameterTypes.addAll(method.getParameterTypeList());
			methodParameterTypeCount += methodParameterTypes.size();
			}
			
		}

		int methodCount = classObject.getNumberOfMethods() + classObject.getConstructorList().size();
		int totalParameterCount = classParameterTypes.size() +1;
		methodParameterTypeCount += methodCount;
		float camc = (float) methodParameterTypeCount / (methodCount * totalParameterCount);
/*		System.out.println(methodParameterTypeCount);
		System.out.println(methodCount);
		System.out.println(totalParameterCount);*/
		return camc;
	}


}

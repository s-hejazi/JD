package metrics;

import ast.ClassObject;
import ast.MethodObject;
import ast.SystemObject;

/**
The ratio of the number of methods inherited by a class to the number of methods accessible by member methods 
of the class. Interpreted as the average across all classes in a design of the ratio of the number 
of methods inherited by a class to the total number of methods available 
to that class, i.e. inherited and defined methods. 
*/

public class MFA 
{
	float ratioperclass;
	//calculating MFA
	public MFA(SystemObject system){
		for(ClassObject classobject :system.getClassObjects())
		{
		int overridecount=0;
		//removing the method overrides
		for(MethodObject methodobject:classobject.getMethodList())
		{
			if(methodobject.overridesMethod())
			{
			overridecount++;	
			}
		}
		
		int nume = (parentmethods(classobject.getName(), system)-overridecount);
		int deno = ((parentmethods(classobject.getName(), system)-overridecount) + classobject.getNumberOfMethods()) + classobject.getConstructorList().size();
		
		if(Float.valueOf((nume))/Float.valueOf(deno)>0 && (Float.valueOf((nume))/Float.valueOf(deno))<5)
		{
		ratioperclass+=Float.valueOf((nume))/Float.valueOf(deno);
		
		}
		}

		System.out.println("MFA = "+Float.valueOf(ratioperclass)/Float.valueOf(system.getClassNumber()));
	}
	//calculating the inherited methods
	int parentmethods(String classname,SystemObject system)
	{
		int methodcount=0;
		try
		{
			
		ClassObject clo=system.getClassObject(system.getClassObject(classname).getSuperclass().toString());	
		for(MethodObject methodobject:clo.getMethodList())
		{
				if(!methodobject.getAccess().equals("private"))
				{
					methodcount++;
				}
		}	

		String temp1 = system.getClassObject(classname).getSuperclass().toString();
		return methodcount+parentmethods(temp1,system);
		}
		catch(Exception e)
		{
		return 0;
		}
		
	}
	
}
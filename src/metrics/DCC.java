package metrics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ast.ClassObject;
import ast.FieldObject;
import ast.MethodObject;
import ast.SystemObject;
import ast.TypeObject;

public class DCC {
// package.class name is considered
	List <String> classNameList = new ArrayList <String>();
	public DCC(SystemObject system){
		int dcc =0 ;		
		for(ClassObject co : system.getClassObjects()){
			classNameList.add(co.getName());
		}
		for(ClassObject co : system.getClassObjects()){
			Set <String> coupledClasses = new HashSet <String>();
			if(co.getFieldList() != null && co.getFieldList().size() != 0)
				getFieldTypes(co, coupledClasses);
			if(co.getMethodList() != null)
				getPrameterTypes(co, coupledClasses);
			dcc+= coupledClasses.size();
		}

		System.out.println( "DCC = " + (float) dcc / classNameList.size());
	}

	private void getFieldTypes(ClassObject co, Set <String> coupledClasses) {

			for (String className : classNameList ){
				if(!className.equals(co.getName()) && co.hasFieldType(className)){
					coupledClasses.add(className);
				}
			}
	}

	private void getPrameterTypes(ClassObject co, Set <String> coupledClasses) {
		for (MethodObject method : co.getMethodList())
		{
			for(TypeObject type : method.getParameterTypeList())
			{
				if (!type.toString().equals(co.getName()) && classNameList.contains(type.toString())){
					coupledClasses.add(type.toString());
				}
			}
		}
		
	}
}

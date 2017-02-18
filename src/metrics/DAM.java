package metrics;

import java.util.List;
import java.util.Set;

import ast.ClassObject;
import ast.FieldObject;
import ast.SystemObject;

//Assumption:
//In total number of attributes, all are considered, including the ones without access modifiers
//
public class DAM {

	public DAM(SystemObject system)
	{
		Set <ClassObject> classObjects = system.getClassObjects();
		float dam = 0;
		for (ClassObject co : classObjects){
	
			if (co.getFieldList() != null && co.getFieldList().size() != 0){
			List <FieldObject> fields = co.getFieldList();
			dam += calculateAccessRatio (fields);
			}
			}
		dam /= classObjects.size(); 
		System.out.println("DAM = " + dam);
		}

private float calculateAccessRatio(List<FieldObject> fields) {
	int privateProtectedCount = 0 ;
	for( FieldObject f : fields){
		if( f.getAccess().toString().equals("private") || f.getAccess().toString().equals("protected")){
			privateProtectedCount ++;
		}
								}
	return (privateProtectedCount / fields.size());
}
}

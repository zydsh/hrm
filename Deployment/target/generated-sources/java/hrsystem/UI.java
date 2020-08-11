package hrsystem;


import hrsystem.ui.UIApp;
import hrsystem.ui.UIAppOps;
import hrsystem.ui.UIFincrud;
import hrsystem.ui.UIPort1;

import io.ciera.runtime.summit.application.IApplication;
import io.ciera.runtime.summit.application.IRunContext;
import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.components.Component;
import io.ciera.runtime.summit.exceptions.BadArgumentException;
import io.ciera.runtime.summit.exceptions.EmptyInstanceException;
import io.ciera.runtime.summit.exceptions.XtumlException;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;


public class UI extends Component<UI> {

    private Map<String, Class<?>> classDirectory;

    public UI(IApplication app, IRunContext runContext, int populationId) {
        super(app, runContext, populationId);



        classDirectory = new TreeMap<>();

    }

    // domain functions
    public void Reply( final String p_msg,  final boolean p_state ) throws XtumlException {
    }



    // relates and unrelates


    // instance selections


    // relationship selections


    // ports
    private UIApp UIApp;
    public UIApp App() {
        if ( null == UIApp ) UIApp = new UIApp( this, null );
        return UIApp;
    }
    private UIAppOps UIAppOps;
    public UIAppOps AppOps() {
        if ( null == UIAppOps ) UIAppOps = new UIAppOps( this, null );
        return UIAppOps;
    }
    private UIFincrud UIFincrud;
    public UIFincrud Fincrud() {
        if ( null == UIFincrud ) UIFincrud = new UIFincrud( this, null );
        return UIFincrud;
    }
    private UIPort1 UIPort1;
    public UIPort1 Port1() {
        if ( null == UIPort1 ) UIPort1 = new UIPort1( this, null );
        return UIPort1;
    }


    // utilities


    // component initialization function
    @Override
    public void initialize() throws XtumlException {

    }

    @Override
    public String getVersion() {
        Properties prop = new Properties();
        try {
            prop.load(getClass().getResourceAsStream("UIProperties.properties"));
        } catch (IOException e) { /* do nothing */ }
        return prop.getProperty("version", "Unknown");
    }
    @Override
    public String getVersionDate() {
        Properties prop = new Properties();
        try {
            prop.load(getClass().getResourceAsStream("UIProperties.properties"));
        } catch (IOException e) { /* do nothing */ }
        return prop.getProperty("version_date", "Unknown");
    }

    @Override
    public boolean addInstance( IModelInstance<?,?> instance ) throws XtumlException {
        if ( null == instance ) throw new BadArgumentException( "Null instance passed." );
        if ( instance.isEmpty() ) throw new EmptyInstanceException( "Cannot add empty instance to population." );

        return false;
    }

    @Override
    public boolean removeInstance( IModelInstance<?,?> instance ) throws XtumlException {
        if ( null == instance ) throw new BadArgumentException( "Null instance passed." );
        if ( instance.isEmpty() ) throw new EmptyInstanceException( "Cannot remove empty instance from population." );

        return false;
    }

    @Override
    public UI context() {
        return this;
    }

    @Override
    public Class<?> getClassByKeyLetters(String keyLetters) {
        return classDirectory.get(keyLetters);
    }

}

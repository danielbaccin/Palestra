package br.com.kenuiapps.palestra;

import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;

import br.com.kenuiapps.palestra.dao.PalestraDAO;
import br.com.kenuiapps.palestra.helper.DataBaseHelper;

/**
 * Created by daniel on 13/05/15.
 */
public class PalestraDAOTest extends AndroidTestCase {

    SQLiteDatabase bd;

    public void testCreateDb()
    {
        mContext.deleteDatabase(DataBaseHelper.BANCO_DADOS);

        bd = new PalestraDAO(mContext).getDb();

        assertTrue(bd.isOpen());
    }

    public void testCloseDb()
    {
        mContext.deleteDatabase(DataBaseHelper.BANCO_DADOS);

        bd = new PalestraDAO(mContext).getDb();
        bd.close();

        assertFalse(bd.isOpen());
    }


}

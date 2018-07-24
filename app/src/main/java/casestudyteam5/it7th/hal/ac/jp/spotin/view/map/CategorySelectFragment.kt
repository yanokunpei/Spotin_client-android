package casestudyteam5.it7th.hal.ac.jp.spotin.view.map

import android.app.DialogFragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.GridView
import casestudyteam5.it7th.hal.ac.jp.spotin.R
import kotlinx.android.synthetic.main.activity_map.*

class CategorySelectFragment : DialogFragment() {

  private lateinit var gv: GridView
  private val categorys: Array<String> = arrayOf(
    "amusement_park",
    "cafe",
    "department",
    "food",
    "gym",
    "mall",
    "museum",
    "police",
    "restaurant",
    "shop",
    "spa",
    "zoo")
  private val categoryName: Array<String> = arrayOf(
    "amusement\npark",
    "cafe",
    "department",
    "food",
    "gym",
    "mall",
    "museum",
    "police",
    "restaurant",
    "shop",
    "spa",
    "zoo")
  private val images: Array<Int> = arrayOf(
    R.drawable.amusement_park,
    R.drawable.cafe,
    R.drawable.department,
    R.drawable.food,
    R.drawable.gym,
    R.drawable.mall,
    R.drawable.museum,
    R.drawable.police,
    R.drawable.restaurant,
    R.drawable.shop,
    R.drawable.spa,
    R.drawable.zoo)

  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {

    var rootView: View = inflater!!.inflate(R.layout.flagment_category_select, null)
    var mapAct = activity as MapActivity

    gv = rootView.findViewById(R.id.categorySelectGridView)
    dialog.setTitle("Category select")
    gv.adapter = CategorySelectAdapter(activity.applicationContext, categorys, categoryName, images)

    gv.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, position, id ->
      mapAct.presenter.selectedCategory = categorys[position]
      dismiss()
    }
    return rootView
  }
}

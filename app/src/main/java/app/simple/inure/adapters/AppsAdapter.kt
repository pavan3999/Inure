package app.simple.inure.adapters

import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import app.simple.inure.R
import app.simple.inure.decorations.viewholders.VerticalListViewHolder
import app.simple.inure.glide.util.AppIconExtensions.loadAppIcon
import app.simple.inure.util.PackageUtils.getApplicationName


class AppsAdapter(private val apps: MutableList<ApplicationInfo>) : RecyclerView.Adapter<AppsAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.adapter_all_apps, parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.icon.loadAppIcon(holder.itemView.context, apps[position].packageName)
        holder.name.text = getApplicationName(holder.itemView.context, apps[position])
        holder.packageId.text = apps[position].packageName
        holder.container.setOnClickListener {

        }
    }

    override fun getItemCount(): Int {
        return apps.size
    }

    inner class Holder(itemView: View) : VerticalListViewHolder(itemView) {
        val icon: ImageView = itemView.findViewById(R.id.adapter_all_app_icon)
        val name: TextView = itemView.findViewById(R.id.adapter_all_app_name)
        val packageId: TextView = itemView.findViewById(R.id.adapter_all_app_package_id)
        val container: ConstraintLayout = itemView.findViewById(R.id.adapter_all_app_container)
    }
}
